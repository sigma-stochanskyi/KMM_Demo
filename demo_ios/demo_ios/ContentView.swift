import SwiftUI
import demo_kmm_module

struct ContentView: View {
	let greet = "Hola"

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
