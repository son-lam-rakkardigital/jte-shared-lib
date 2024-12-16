import org.example.MyLibrary

def call(String message) {
    def lib = new MyLibrary()
    println(lib.returnHelloMessage("Jenkins"))
    println("Executing myStep: ${message}")
}
