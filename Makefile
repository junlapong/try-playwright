test:
	@mvn compile exec:java -Dexec.mainClass="com.example.Example"

sc:
	@mvn compile exec:java -Dexec.mainClass="com.example.WebKitScreenshot"

record:
	@mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen wikipedia.org"
