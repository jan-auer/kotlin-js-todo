if (defined.PRODUCTION) {
  // Activate Webpack minifier plugins
  config.plugins.push(new webpack.optimize.ModuleConcatenationPlugin());
  config.plugins.push(new webpack.optimize.UglifyJsPlugin({ minimize: true }));

  // Use minified output form kotlin-dce-js. This patches webpack to look for
  // minified output in the correct directory, as gradle will automatically move
  // all assets to that folder.
  config.context += '/min';

  // The kotlin frontend plugin does not know about dce-js and that it puts the
  // minified kotlin.js in a different location. However, is set to a fixed
  // file URL in the generated package.json (have a look in build/package.json
  // to see where it points to). Therefore, we have to tell webpack's resolver
  // where to look for the minified version instead.
  config.resolve.alias = { kotlin: config.context + '/kotlin.js' };
}
