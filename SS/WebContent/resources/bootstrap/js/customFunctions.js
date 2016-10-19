jsf.ajax.addOnEvent(function(data) {
						var ajaxstatus = data.status; // Can be "begin", "complete" and "success"
						//var ajaxloader = document.getElementById("ajaxloader");

						switch (ajaxstatus) {
						case "begin": // This is called right before ajax request is been sent.
							//ajaxloader.style.display = 'block';
							$
									.blockUI({
										message : '<h3><img src="../resources/images/loading.gif" /> Loading data...</h3>'
									});
							break;

						case "complete": // This is called right after ajax response is received.
							$.unblockUI();
							//ajaxloader.style.display = 'none';
							break;

						case "success": // This is called when ajax response is successfully processed.
							// NOOP.
							break;
						}
					});