const path = require('path');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const HtmlWebpackPlugin = require('html-webpack-plugin');

const entrypoint = './src/main.ts';
const filename = 'ryanet.js'
const output = './../dist'

module.exports = {

    entry: entrypoint,

    output: {
      path: path.resolve(__dirname, output),
      filename: filename
    },

    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015']
                }
            },

            {
                test: /\.ts$/,
                loader: 'ts-loader',
                options: {
                    configFile: "tsconfig.json"
                }
            },

            {
                test: /\.vue$/,
                loader: 'vue-loader',
            }
        ]
    },

    resolve: {
        extensions: ['.ts', '.js'],
        modules: [
            path.resolve('./'),
            path.resolve('./node_modules'),
        ]
    },

    plugins: [
        // new BundleAnalyzerPlugin({
        //     analyzerMode: 'static'
        // }),
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'index.html',
            inject: true
        })
    ]
};