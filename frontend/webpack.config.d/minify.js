if (defined.PRODUCTION) {
  // Activate Webpack minifier plugins
  config.plugins.push(new webpack.optimize.ModuleConcatenationPlugin());
  config.plugins.push(new webpack.optimize.UglifyJsPlugin({ minimize: true }));

  // Use minified output form kotlin-dce-js
  config.context += '/min';
  config.resolve.alias = { kotlin: config.context + '/kotlin.js' };
}
