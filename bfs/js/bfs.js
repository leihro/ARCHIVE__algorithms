//breath-first-search
var bfs = function(start, nodes){
    'use strict';
    //frontier 是每一个待search的行，从start开始
    var frontier = [start];
    //从0行开始，每一行++
    var level = 0, levels = {};
    //每一行一个循环，frontier来自上一行每个节点的相邻节点
    var tarArr = [];
    while (0 < frontier.length) {
        var next = []; //下一行将要遍历的节点
        for (var i in frontier) {
            var node = frontier[i];
            //给节点标记level，每一个循环后，进入下一行(下一个level)
            levels[node] = level;
            tarArr.push(node);

            for (var i in nodes[node]) {
                //nodes总图中每个节点的相邻节点
                var adj = nodes[node][i];
                //void(0) = undefined
                if (void(0) === levels[adj]) {
                    next.push(adj);//新的节点就push进入下一行
                }
            }
        }
        frontier = next;//有就继续下一个循环，否则frontier.length将为空，循环结束
        level += 1;
    }
    return tarArr.join(', ');
}

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

exports.bfs = bfs;
