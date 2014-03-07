phonegap-plugin-loading-spinner
===============================

PhoneGap 3 plugin to show a loading spinner with optional dark overlay.

![screenshot](https://raw.github.com/mobimentum/phonegap-plugin-loading-spinner/master/screenshot.png "Screenshot")


Usage
=====

Add plugin to your project:

    cordova plugin add https://github.com/mobimentum/phonegap-plugin-loading-spinner.git

Show spinner with default arguments:

    spinnerplugin.show();
    
Show spinner with optional arguments:

    spinnerplugin.show({
        overlay: false, // defaults to true
        timeout: 30     // defaults to 0 (no timeout)
    });

Hide spinner:

    spinnerplugin.hide();

Usage with jQuery Mobile
========================

I encourage you to use the following code to gracefully replace the default jQM loader:

    onDeviceReady: function() {
		// Native loading spinner
		if (window.spinnerplugin) {
			$.extend($.mobile, {
				loading: function() {
					// Show/hide spinner
					var arg = arguments ? arguments[0] : '';
					if (arg == 'show') spinnerplugin.show({'overlay':true});
					else if (arg == 'hide') spinnerplugin.hide();			

					// Compatibility with jQM 1.4
					return { loader: function() { } }
				}
			});	
		}
	}

Thus, if the SpinnerPlugin is added and working the native spinner would be used, otherwise the standard jQM loader is fired.
