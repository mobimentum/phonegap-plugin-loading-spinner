//
//  SpinnerPlugin.h
//  IMG Cinema
//
//  Created by Andrea Maschio on 24/12/13.
//
//

#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>

@interface SpinnerPlugin : CDVPlugin{
    UIActivityIndicatorView * indicator;
    UIView *background;
    BOOL showOverlay;
}

-(void)hide:(CDVInvokedUrlCommand*)options;
-(void)show:(CDVInvokedUrlCommand*)options;
@end
