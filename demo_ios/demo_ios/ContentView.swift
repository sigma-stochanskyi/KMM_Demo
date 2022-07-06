import SwiftUI
import demo_kmm_module

struct ContentView: View {
    
    let fetchUseCase = Injector().fetchTestDataUseCase()
    
    @State var greet = ""
    
    func load() {
        fetchUseCase.invoke { result, error in
                if let result = result {
                    self.greet = result.title
                } else if let error = error {
                    greet = "Error: \(error)"
                }
            }
        }

	var body: some View {
        Text(greet).onAppear() {
            load()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
