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
}

-(void)hide:(NSMutableDictionary*)options;
-(void)show:(NSMutableDictionary*)options;
@end
