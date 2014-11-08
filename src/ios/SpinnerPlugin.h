//
//  SpinnerPlugin.h
//  IMG Cinema
//
//  Created by Andrea Maschio on 24/12/13.
//
//  Updated by Modern Alchemists OG on 23/04/2014.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>

@interface SpinnerPlugin : CDVPlugin
{
    UIActivityIndicatorView* indicator;
    BOOL showOverlay;
    int connectionTimeout;
}

-(void)hide:(CDVInvokedUrlCommand*)options;
-(void)show:(CDVInvokedUrlCommand*)options;
@end
