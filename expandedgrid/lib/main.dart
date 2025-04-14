import 'package:animator/animator.dart';
import 'package:expanded_grid/expanded_grid.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        home: ExpandedGridSample(),
    );
  }
}

class ExpandedGridSample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Align(
        alignment: Alignment.center,
        child: AspectRatio(
            aspectRatio: 4 / 3,
            child: ExpandedGrid(
              column: 4,
              row: 5,
              children: <ExpandedGridContent>[
                ExpandedGridContent(
                  rowIndex: 0,
                  columnIndex: 0,
                  rowSpan: 2,
                  columnSpan: 3,
                  child: Container(
                    color: Colors.blue,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 0,
                  columnIndex: 3,
                  rowSpan: 2,
                  columnSpan: 1,
                  child: Container(
                    color: Colors.green,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 2,
                  columnIndex: 0,
                  rowSpan: 2,
                  columnSpan: 2,
                  child: Container(
                    color: Colors.red,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 2,
                  columnIndex: 2,
                  rowSpan: 1,
                  columnSpan: 2,
                  child: Container(
                    color: Colors.yellow,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 3,
                  columnIndex: 2,
                  rowSpan: 2,
                  columnSpan: 1,
                  child: Container(
                    color: Colors.deepPurple,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 3,
                  columnIndex: 3,
                  rowSpan: 2,
                  columnSpan: 1,
                  child: Container(
                    color: Colors.orange,
                  ),
                ),

                ExpandedGridContent(
                  rowIndex: 4,
                  columnIndex: 0,
                  rowSpan: 1,
                  columnSpan: 2,
                  child: Container(
                    color: Colors.teal,
                  ),
                ),

              ],
            )
        ),
      ),
    );
  }
}
