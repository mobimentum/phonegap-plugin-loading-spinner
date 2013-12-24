// Spinner plugin
var spinnerplugin = {
    show: function(msg, successCallback, errorCallback) {
		cordova.exec(
            successCallback,
            errorCallback,
            'SpinnerPlugin',
            'show',
            [{
                "msg": msg,
            }]
        );
    },
    hide: function(successCallback, errorCallback) {
	 
    },
}

// Exports
module.exports = spinnerplugin;
