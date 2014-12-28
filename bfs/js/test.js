
var bfs = require('./bfs.js').bfs;

var nodes = {
     "1": [2, 3, 4],
     "2": [1, 5, 6],
     "3": [1,13],
     "4": [1, 7, 8],
     "5": [2, 9, 10],
     "6": [2],
     "7": [4, 11, 12],
     "8": [4],
     "9": [5],
    "10": [5],
    "11": [7],
    "12": [7],
    "13": [3]
};

var searchResult = bfs(1, nodes);
console.log(searchResult);

