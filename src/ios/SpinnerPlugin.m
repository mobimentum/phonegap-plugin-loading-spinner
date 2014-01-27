//
//  SpinnerPlugin.m
//  IMG Cinema
//
//  Created by Andrea Maschio on 24/12/13.
//
//

#import "SpinnerPlugin.h"
#import <Cordova/CDV.h>
#define PARAM_SHOW_OVERLAY @"overlay"
#define PARAM_AUTO_HIDE_TIMEOUT @"timeout"

@implementation SpinnerPlugin
- (void)pluginInitialize{
    //params init
    showOverlay = YES;
    connectionTimeout = 0;
}
-(void)show:(CDVInvokedUrlCommand*)options{
    NSMutableDictionary* params = [options.arguments objectAtIndex:0];
    
    ;
    
    if([params objectForKey:PARAM_AUTO_HIDE_TIMEOUT]){
        id connectiontimeout =[params objectForKey:PARAM_AUTO_HIDE_TIMEOUT];
        
        if([connectiontimeout isKindOfClass:[NSString class]]){
            NSScanner*scan = [NSScanner scannerWithString:(NSString*)connectiontimeout];
            [scan scanInt:&connectionTimeout];
        }else if([connectiontimeout isKindOfClass:[NSNumber class]]){
            connectionTimeout = [connectiontimeout intValue];
        }
    }
    
    
    id overlayParam = [params objectForKey:PARAM_SHOW_OVERLAY];
    
    if ([overlayParam isKindOfClass:[NSString class]])
    {
        if ([overlayParam isEqualToString:@"false"])
            showOverlay = NO;
    }
    else if (![overlayParam boolValue])
        showOverlay = NO;
    
    if(!indicator){
        indicator = [[UIActivityIndicatorView alloc]initWithFrame:[UIScreen  mainScreen].bounds];
        
    }else{
        [indicator removeFromSuperview];
    }
    if(showOverlay){
        if(!background){
            background = [[UIView alloc]initWithFrame:[UIScreen  mainScreen].bounds];
        }else{
            [background removeFromSuperview];
        }
    }
    
    if(connectionTimeout>0){
        NSTimer *timer= [NSTimer scheduledTimerWithTimeInterval:30 target:self selector:@selector(hide:) userInfo:Nil repeats:NO];
    }
    [self.viewController.view addSubview:background];
    
    
    [background setBackgroundColor:[UIColor blackColor]];
    [background setAlpha:0.8f];
    background.userInteractionEnabled=NO;
    
    [self.viewController.view addSubview:indicator];
[indicator startAnimating];
}
-(void)hide:(CDVInvokedUrlCommand*)options{
    [indicator stopAnimating];
    [background removeFromSuperview];
    [indicator removeFromSuperview];

}
@end
