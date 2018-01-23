// Suppress lint error for dependencies
/* eslint import/no-extraneous-dependencies: ["error", {"devDependencies": true}] */
const webpack = require('webpack');
const webpackMerge = require('webpack-merge');
// const BundleAnalyzerPlugin = require('webpack-bundle-analyzer');
const WebpackNotifierPlugin = require('webpack-notifier');
const FriendlyErrorPlugin = require('friendly-errors-webpack-plugin');

const baseWebpackConfig = require('./webpack.base.config');

module.exports = webpackMerge(baseWebpackConfig, {

    plugins: [

        // uncomment for analyzer
        // new BundleAnalyzerPlugin({
        //     analyzerMode: 'static'
        // }),

        new WebpackNotifierPlugin(),

        // HRM
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),

        new FriendlyErrorPlugin(),
    ],
});
