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

@implementation SpinnerPlugin
- (void)pluginInitialize{
    //params init
    showOverlay = YES;
}
-(void)show:(CDVInvokedUrlCommand*)options{
    NSMutableDictionary* params = [options.arguments objectAtIndex:0];
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
