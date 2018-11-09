# Shared Libraries for a Jenkins pipeline (Docker images)

The context is explained on [my blog](https://vzurczak.wordpress.com/2018/11/09/shared-responsibilities-in-jenkins-pipelines-for-docker-images/).  
This repository contains 4 branches:

* [master](https://github.com/vincent-zurczak/jenkins-pipeline-for-docker-images) contains the skeleton for a project that would use this pipeline.
* [sl-security](https://github.com/vincent-zurczak/jenkins-pipeline-for-docker-images/tree/sl-security) contains the code for a shared library managed by the security team/role.
* [sl-gov](https://github.com/vincent-zurczak/jenkins-pipeline-for-docker-images/tree/sl-gov) contains the code for a shared library managed by the Software governance team/role.
* [sl-all-in-one](https://github.com/vincent-zurczak/jenkins-pipeline-for-docker-images/tree/sl-all-in-one) contains the code for the generic pipeline that uses the other shared libraries. This pipeline is the one configured in the project hosted on the master branch.

You are currently viewing the **sl-security** banch.
