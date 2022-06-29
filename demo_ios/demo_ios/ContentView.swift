import SwiftUI
import demo_kmm_module

struct ContentView: View {
    
    // TODO Should be moved to some DI
	let fetchUseCase = FetchTestDataUseCase(
        testDataRepository: TestDataRepositoryImpl(
            testNetworkDataSource: TestNetworkDataSource(
                networkClient: NetworkClientImpl()
            )
        )
    )
    
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
