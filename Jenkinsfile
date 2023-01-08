pipeline{
  agent any

    tools {
            maven 'Maven 3.3.9'
        }
    stages{
      stage('Git Checkout'){
        steps{
          git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
        }
      }
      stage('Maven Build'){
        steps{
            sh 'mvn clean install'
        }
      }
    }
}