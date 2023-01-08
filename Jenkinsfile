pipeline{
  agent
  tools{
  maven 'Maven 3.3.9'
  jdk 'jdk8'
  }
    stages{
      stage('Git Checkout'){
        steps{
          git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
        }
      }

      stage('Maven test'){
              steps{
                  sh 'mvn test'
              }
            }
      stage('Maven Build'){
        steps{
            sh 'mvn clean install'
        }
      }
    }
}