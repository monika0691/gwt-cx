for /r /d %%x in (*) do (
  pushd "%%x"
  if exist pom.xml mvn install
  popd
)