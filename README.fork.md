### How to
- Check out `develop-mine` branch (branched from `develop`)
- Install the `scala` stack on Windows via `coursier`: https://www.scala-lang.org/download/ (first link in page)
- (optional) Use VS Code as IDE
- For the rest, refer to instructions in the [README](./README.md) file, then the utility bat file for execution (see below)
- Post extraction:
  - Voices: to extract the `ogg` files from `lip` files, use `lipreader` from the [rdbreader](https://github.com/mfroment/rdbreader/tree/mine) project ([instructions](https://github.com/mfroment/rdbreader/blob/mine/README.fork.md)).

### Changes
- Modified for `sbt=1.8.2` (minus the `idea` plugin, just removed it)
- Marked `rdbtype` 1020003 i.e. "Lip Sync Voices" as "understood"
- Added a [bat file](./scripts/extract.bat) for running the extract for all audio