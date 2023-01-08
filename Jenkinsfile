pipeline{
  agent any
  tool name: 'maven' type: 'maven'

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