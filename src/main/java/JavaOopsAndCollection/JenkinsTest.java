package JavaOopsAndCollection;

public class JenkinsTest {
    /*1. What is Jenkins and what is it used for?

Jenkins is an open-source automation tool used for Continuous Integration and Continuous Delivery (CI/CD).
It automates building, testing, and deploying applications whenever code changes are made.

2. What do you need before installing Jenkins?
Java (JDK 8 or above)
Supported OS (Windows/Linux/Mac)
Minimum RAM (2GB+ recommended)
Web browser
Internet connection (for plugins)


3. Why LTS over latest Jenkins release?

LTS (Long Term Support) is preferred because:

More stable and tested
Fewer bugs and production-safe
Regular security fixes

Latest release is used when:
You need newest features
You are testing or contributing to Jenkins development

4. Difference between job/project and build
Job/Project: Configuration of automation tasks (what to run)
Build: One execution instance of that job (actual run)

5. What is a workspace?
A workspace is a directory on Jenkins server where:
Source code is downloaded
Builds are executed
Temporary files are stored

6. What is a build trigger?
A build trigger defines when a job should run. Examples:

Git commit (webhook)
Scheduled (cron)
Manual trigger
After another job completes

7. What is a parameterized job?
A parameterized job allows users to pass input values while running a build (e.g., environment = dev/staging/prod).
Used for dynamic builds and deployments.

8. Pipeline as Code vs Infrastructure as Code
Pipeline as Code: CI/CD pipeline defined in code (Jenkinsfile)
Infrastructure as Code (IaC): Infrastructure defined using code (servers, networks, etc.)

9. Benefits of pipelines over normal jobs
Version controlled (stored in Git)
Easy to maintain and reuse
Supports complex workflows
Better visualization and scalability
Supports CI/CD best practices

10. What is a Jenkinsfile?
A Jenkinsfile is a text file that contains pipeline definition code (stages, steps, and configuration)
used by Jenkins to execute CI/CD pipeline.

11. Declarative vs Scripted pipeline
Declarative Pipeline:
Structured and easy to read
Uses predefined syntax
Recommended for most users
Scripted Pipeline:
Flexible and code-like (Groovy-based)
More complex but powerful

12. Advantages of Blue Ocean
Modern UI for Jenkins
Easy pipeline visualization
Better debugging and logs view
Simplified pipeline creation
Better user experience for CI/CD workflows



13. What is a multibranch pipeline?
A multibranch pipeline automatically creates and runs pipelines for each
branch in a repository (e.g., feature, main, dev branches).

14. What is a pull request?
A pull request is a request to merge code changes from one branch into another (e.g., feature → main).
It is used for code review before merging.


*/
}
