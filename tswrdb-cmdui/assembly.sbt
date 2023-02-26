enablePlugins(AssemblyPlugin)

assemblyJarName := s"tswrdb-${version.value}.jar"

mainClass := Some("com.joakibj.tswrdb.TswRdb")