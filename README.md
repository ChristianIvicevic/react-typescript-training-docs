# React/Typescript Training Documentation

This is the training material and documentation for the Comsysto React/Typescript Training. You can access two publicly available deployed instances of the documentation, the `master` instance which is the most recent officially released version and a `dev` instance which is a snapshot of the next version in the works. The latter includes an _Unreleased_ section in the changelog that gives an overview of what is already included in that version.

| Instance | Status |
| -------- | ------ |
| [`master`](https://comsysto-react-typescript-training.netlify.com)  | [![Netlify Status](https://api.netlify.com/api/v1/badges/72b65bbb-fbb3-49d2-ba27-4391b5b80d8f/deploy-status)](https://comsysto-react-typescript-training.netlify.com)     |
| [`dev`](https://comsysto-react-typescript-training-dev.netlify.com) | [![Netlify Status](https://api.netlify.com/api/v1/badges/3968112b-2b5d-4782-ae4a-8a80a50428dd/deploy-status)](https://comsysto-react-typescript-training-dev.netlify.com) |

If you find errors or omissions in the documentation, please don't hesitate to [submit an issue or open a pull request](https://github.com/ChristianIvicevic/react-typescript-bootcamp-docs/issues) with a fix. We also encourage you to ask questions and discuss any aspects of the project.

## Local Development

If you're interested in contributing to the project, please read the [CONTRIBUTING.md](./CONTRIBUTING.md) file first.

### Requirements

In order to build the project locally you need the following infrastructure:

* [Node](https://nodejs.org/en/)
* [yarn](https://yarnpkg.com/lang/en/)
* Java 8

The project uses Node scripts defined in `package.json` that are run by yarn. Gradle and the Asciidoc(tor) dependencies are automatically installed using the supplied Gradle wrapper.

### Build

After cloning the repository for the first time run `yarn` to install all dependencies used during postprocessing.

In order to actually build the project, run `yarn build`. The compilation output is stored in `build/asciidoc/html5/` and you can just view the `build/asciidoc/html5/index.html` file in your browser.

## Deployments

For each opened pull request against the `develop` branch Netlify will automatically create preview deployments and link them to the pull request. After merging pull requests into `develop` the `dev` instance is deployed with the new changes.
