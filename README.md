# Kotlin Multi-Platform TodoMVC

This is a multiplatform Kotlin project implementing a subset of the [TodoMVC](http://todomvc.com/)
application. While it is not intended to showcase an MV* framework per se, it should provide a
starting point for setting up multi-platform projects with the Kotlin toolchain. Please note, that
most of the toolchain and frameworks used in this project are still pre-release at the time of
writing.

This project was created as demo for our talk, which will be available online soon.

<div align="center">
    <img src="https://i.imgur.com/gzjRTct.png" alt="Screenshot" width="702" />
</div>

## Overview

The project consists of three modules:

 - **domain**: Common code that is required by both other modules. It builds on
   `kotlin-platform-common`, which only allows platform-independent implementations based on
   `kotlin-stdlib-common`. Specifically, it provides the `Todo` domain class so it can be shared
   between server and client.
 - **backend**: The server-portion of the TodoMVC example. It builds on `kotlin-platform-jre8` and
   Spring Boot. Additionally, it implements *domain* for the JVM.
 - **frontend**: The client-portion of the TodoMVC example. It builds on `kotlin-platform-js` and
   `kotlinx-html-js`. Additionally, it implements *domain* for the browser.

## Development

This project follows the standard gradle workflow. To build and run use `./gradlew` or `./gradlew.bat`
on *nix systems and Windows, respectively. The relevant targets are:

 - `backend:bootRun` starts the Spring Boot web server and exposes its API for the frontend.
 - `frontend:build` builds the JavaScript bundle and places an *index.html* file in the output
   folder. Open that file, usually located in `frontend/build/resources/main/index.html` to open the
   Todo list.

Sadly, the IntelliJ IDEA import does not work yet. The
[fixing commit](https://github.com/jetbrains/kotlin/commit/bdad58cec6849d3bc0a77b6d753adb76145aa21e)
has already landed in the Kotlin Plugin master, so it is just a matter of time.

## Useful Resources

 - [Kotlin Frontend Plugin](https://github.com/Kotlin/kotlin-frontend-plugin): Use npm, webpack and
   karma in a convenient way during the gradle build process.
 - [ts2kt](https://github.com/Kotlin/ts2kt): Convert typescript definitions to kotlin bindings.
 - [Coroutines](https://github.com/Kotlin/kotlinx.coroutines): Utilities and convenience functions
   to handle coroutines more easily.
 - [Kotlin DCE](https://kotlinlang.org/docs/reference/javascript-dce.html): Dead code elimination to
   reduce the file size of the kotlin library's `kotlin.js`.
