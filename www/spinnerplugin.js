// Spinner plugin
var spinnerplugin = {
    show: function(args, successCallback, errorCallback) {
		cordova.exec(
            successCallback,
            errorCallback,
            'SpinnerPlugin',
            'show',
            [args]
        );
    },
    hide: function(successCallback, errorCallback) {
		cordova.exec(
            successCallback,
            errorCallback,
            'SpinnerPlugin',
            'hide',
            []
        );
    },
}

// Exports
module.exports = spinnerplugin;
