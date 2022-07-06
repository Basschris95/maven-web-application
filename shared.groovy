Def call(String StageName) {
    if ("${StageName}" == Build") {
      sh 'mvn clean'
      sh 'mvn install'
    }
    else if ("${StageName}" == CodeQualityAnalysis") {
      sh 'mvn clean'
      sh 'mvn sonar:sonar'
    }
    else if ("${StageName}" == BackupArtifact") {
      sh 'mvn clean'
      sh 'mvn deploy'
    }
    else if ("${StageName}" == Authorisation") {
      timeout(time:9, unit:'HOURS') {
        input message: 'Application ready for deployment, Please review and approve'
        } 
      }
   }
