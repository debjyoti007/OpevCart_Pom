├── src/
│   ├── testBase/              # Base class for WebDriver setup
│   ├── testCases/             # Test classes (Login, etc.)
│   ├── pageObjects/           # Page classes for UI elements
│   └── utilities/             # ExtentReportManager, Excel utils
├── test-output/               # Generated reports and logs
├── testData/                  # Excel files for DDT
├── logs/                      # Automation logs
├── testng.xml                 # Main TestNG suite
├── testng2.xml                # Alternate suite config
└── pom.xml                    # Maven dependencies
🧪 How to Run
Clone the repo:

bash
git clone https://github.com/debjyoti007/OpevCart_Pom.git
Import into Eclipse/IntelliJ as a Maven project.

Run testng.xml from your IDE or via CLI:

bash
mvn test -DsuiteXmlFile=testng.xml
📈 Reporting
After execution, navigate to:

test-output/emailable-report.html
test-output/index.html
for detailed run summaries and screenshots (if configured).

👨‍💻 Author
Debjyoti – Sr. QA Analyst Lead, Passionate about
