//
//  SpinnerPlugin.m
//  IMG Cinema
//
//  Created by Andrea Maschio on 24/12/13.
//
//

#import "SpinnerPlugin.h"
#import <Cordova/CDV.h>

@implementation SpinnerPlugin
-(void)show:(NSMutableDictionary*)options{
    if(!indicator){
        indicator = [[UIActivityIndicatorView alloc]initWithFrame:[UIScreen  mainScreen].bounds];
        
    }else{
        [indicator removeFromSuperview];
    }
    
    if(!background){
        background = [[UIView alloc]initWithFrame:[UIScreen  mainScreen].bounds];
    }else{
        [background removeFromSuperview];
    }
    
    
    
    [self.viewController.view addSubview:background];
    
    
    [background setBackgroundColor:[UIColor blackColor]];
    [background setAlpha:0.8f];
    background.userInteractionEnabled=NO;
    
    [self.viewController.view addSubview:indicator];
[indicator startAnimating];
}
-(void)hide:(NSMutableDictionary*)options{
    [indicator stopAnimating];
    [background removeFromSuperview];
    [indicator removeFromSuperview];

}
@end
