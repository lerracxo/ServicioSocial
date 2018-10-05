CREATE TABLE calificacion (
    id_persona integer,
    id_periodo integer,
    id_grupo integer,
    id_materia integer,
    puntualidad text,
    contenido text,
    didactica text,
    planeacion text,
    evaluacion text,
    actitud text,
    promedio text,
    id integer NOT NULL,
    comprobante text
);


--
-- Name: calificacion_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE calificacion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: calificacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE calificacion_id_seq OWNED BY calificacion.id;


--
-- Name: contacto; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE contacto (
    id_persona integer NOT NULL,
    f_telefono text,
    m_telefono text,
    t_telefono text,
    ext text,
    mail text,
    cedula text,
    rfc text,
    f_ingreso text,
    grado text,
    exop text
);


--
-- Name: curso; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE curso (
    id integer NOT NULL,
    id_persona integer,
    curso text,
    inicio text,
    termino text,
    tipo text,
    constancia text
);


--
-- Name: curso_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE curso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: curso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE curso_id_seq OWNED BY curso.id;


--
-- Name: grupo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE grupo (
    id integer NOT NULL,
    grupo text
);


--
-- Name: grupo_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE grupo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: grupo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE grupo_id_seq OWNED BY grupo.id;


--
-- Name: importcalif; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE importcalif (
    nombre text,
    periodo text,
    grupo text,
    materia text,
    puntualidad text,
    contenido text,
    didactica text,
    planeacion text,
    evaluacion text,
    actitud text
);


--
-- Name: importcurso; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE importcurso (
    nombre text,
    curso text,
    fechai text,
    fechaf text,
    horas text
);


--
-- Name: materia; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE materia (
    id integer NOT NULL,
    materia text
);


--
-- Name: materia_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE materia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: materia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE materia_id_seq OWNED BY materia.id;


--
-- Name: periodo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE periodo (
    id_tempo integer NOT NULL,
    periodo text
);


--
-- Name: periodo_materia; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE periodo_materia (
    id_periodo integer NOT NULL,
    fec_inicio date,
    fec_fin date,
    fec_desc text
);


--
-- Name: periodo_materia_id_periodo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE periodo_materia_id_periodo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: periodo_materia_id_periodo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE periodo_materia_id_periodo_seq OWNED BY periodo_materia.id_periodo;


--
-- Name: periodo_serial_id_tempo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE periodo_serial_id_tempo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: periodo_serial_id_tempo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE periodo_serial_id_tempo_seq OWNED BY periodo.id_tempo;


--
-- Name: persona; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE persona (
    id_persona integer NOT NULL,
    nombres text,
    a_paterno text,
    a_materno text,
    nacionalidad text
);


--
-- Name: persona_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE persona_id_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: persona_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE persona_id_persona_seq OWNED BY persona.id_persona;


--
-- Name: profesor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE profesor (
    id_profesor integer NOT NULL,
    cedula text,
    rfc text,
    fec_ingreso date,
    ex_oposicion text
);


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    username text,
    pass text,
    date date,
    rol text
);


--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;


--
-- Name: calificacion id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY calificacion ALTER COLUMN id SET DEFAULT nextval('calificacion_id_seq'::regclass);


--
-- Name: curso id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY curso ALTER COLUMN id SET DEFAULT nextval('curso_id_seq'::regclass);


--
-- Name: grupo id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY grupo ALTER COLUMN id SET DEFAULT nextval('grupo_id_seq'::regclass);


--
-- Name: materia id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY materia ALTER COLUMN id SET DEFAULT nextval('materia_id_seq'::regclass);


--
-- Name: periodo id_tempo; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY periodo ALTER COLUMN id_tempo SET DEFAULT nextval('periodo_serial_id_tempo_seq'::regclass);


--
-- Name: periodo_materia id_periodo; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY periodo_materia ALTER COLUMN id_periodo SET DEFAULT nextval('periodo_materia_id_periodo_seq'::regclass);


--
-- Name: persona id_persona; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY persona ALTER COLUMN id_persona SET DEFAULT nextval('persona_id_persona_seq'::regclass);


--
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- Name: calificacion calificacion_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY calificacion
    ADD CONSTRAINT calificacion_pkey PRIMARY KEY (id);


--
-- Name: contacto contacto_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY contacto
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (id_persona);


--
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id);


--
-- Name: periodo_materia periodo_materia_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY periodo_materia
    ADD CONSTRAINT periodo_materia_pkey PRIMARY KEY (id_periodo);


--
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id_persona);


--
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (id_profesor);


--
-- Name: profesor profesor_id_profesor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY profesor
    ADD CONSTRAINT profesor_id_profesor_fkey FOREIGN KEY (id_profesor) REFERENCES persona(id_persona) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: public; Type: ACL; Schema: -; Owner: -
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
