node(){
    env.CLAIR_IP="172.17.0.1"
    
    cleanWs()
    stage("CheckOut"){
        checkout scm
    }
   
    stage("Email"){
       
        emailext    body: '${FILE,path="target/dependency-check-report.html"}',
                    mimeType: 'text/html', subject: 'Library Vulnerability Analysis: ${JOB_NAME} - ${BUILD_NUMBER}', 
                    attachmentsPattern: 'target/dependency-check-report.html',
                    to: 'dnyaneshwar.mundhe@infostretch.com'
    }

    
    stage("Run clair-db"){
        sh "docker run -p 5432:5432 -d --name db arminc/clair-db:2017-10-17"
    }

    stage("Run postgres"){
        sh "docker run -p 6060:6060 --link db:postgres -d --name clair arminc/clair-local-scan:v2.0.1"
    }
	
    stage("Pull Docker Image"){
        sh "docker pull benhall/elasticsearch:1.4.2"
    }

    stage("Docker Image Vulnerability Analysis"){
        sh "clair-scanner_linux_amd64 --ip 172.17.0.1 -r report.json  benhall/elasticsearch:1.4.2"

        emailext    body: '${FILE,path="target/security_report.html"}',
                    mimeType: 'text/html', subject: 'Container Image Vulnerability Analysis: ${JOB_NAME} - ${BUILD_NUMBER}', 
                    attachmentsPattern: 'target/security_report.html',
                    to: 'dnyaneshwar.mundhe@infostretch.com'
    }

}
