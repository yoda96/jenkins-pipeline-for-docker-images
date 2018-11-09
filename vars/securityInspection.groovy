
def call(String imageName, String buildId) { 

	// We assume clair-scanner is available in the path
	def host = sh(returnStdout: true, script: 'hostname -i').trim()
	clair-scanner -c <CLAIR_SERVER_URL> --ip ${host} --t High ${imageName}:${buildId}
}

// If you use Dadgda instead of Clair, you simply run a Python script.
// The installation is a little bit different, but the pipeline step would remain simple.
