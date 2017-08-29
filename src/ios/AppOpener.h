#import <Cordova/CDVPlugin.h>

@interface AppOpener : CDVPlugin {
}

// The hooks for our plugin commands
- (void)echo:(CDVInvokedUrlCommand *)command;
- (void)getDate:(CDVInvokedUrlCommand *)command;
- (void)phone:(CDVInvokedUrlCommand *)command;
- (void)email:(CDVInvokedUrlCommand *)command;
@end
