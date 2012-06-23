for /r /d %%x in (*) do (
  pushd "%%x"
  mvn install
  popd
)