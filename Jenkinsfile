node(){
    env.CLAIR_IP="172.17.0.1"
    
    cleanWs()
    stage("CheckOut"){
        checkout scm
    }
   
  
    
    stage("Run clair-db"){
        sh " sudo docker run -p 5432:5432 -d --name db arminc/clair-db:2017-10-17"
    }

    stage("Run postgres"){
        sh "sudo docker run -p 6060:6060 --link db:postgres -d --name clair arminc/clair-local-scan:v2.0.1"
    }
	
    stage("Pull Docker Image"){
        sh "sudo docker pull benhall/elasticsearch:1.4.2"
    }

    stage("Docker Image Vulnerability Analysis"){
        sh "clair-scanner_linux_amd64 --ip 172.17.0.1 -r report.json  benhall/elasticsearch:1.4.2"
    }

}
