import SwiftUI
import demo_kmm_module

@main
struct iOSApp: App {
    
    init() {
        KoinHelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
