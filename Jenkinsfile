node(){
    env.CLAIR_IP="172.17.0.1"
    
    cleanWs()
    stage("CheckOut"){
        checkout scm
    }
   
  
    
    stage("Run clair-db"){
        sh "docker run -p 5432:5432 -d --name dbleia arminc/clair-db:2017-10-17"
    }

    stage("Run postgres"){
        sh "docker run -p 6060:6060 --link db:postgres -d --name clairvader arminc/clair-local-scan:v2.0.1"
    }
	
    stage("Pull Docker Image"){
        sh "docker pull benhall/elasticsearch:1.4.2"
    }

    stage("Docker Image Vulnerability Analysis"){
        sh "clair-scanner_linux_amd64 --ip 172.17.0.1 -r report.json  benhall/elasticsearch:1.4.2"
    }

}
