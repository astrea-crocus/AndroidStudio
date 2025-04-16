import 'package:expanded_grid/expanded_grid.dart';
import 'package:flutter/material.dart';

import 'bleu.dart';
import 'jaune.dart';
import 'rouge.dart';
import 'vert.dart';
import 'violet.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Flutter Demo', home: ExpandedGridSample());
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
                  child: IconButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Bleu()),
                      );
                    },
                    icon: Icon(
                      Icons.cached,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon cached',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 0,
                columnIndex: 3,
                rowSpan: 2,
                columnSpan: 1,
                child: Container(
                  color: Colors.green,
                  child: IconButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Vert()),
                      );
                    },
                    icon: Icon(
                      Icons.image,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon image',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 2,
                columnIndex: 0,
                rowSpan: 2,
                columnSpan: 2,
                child: Container(
                  color: Colors.red,
                  child: IconButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Rouge()),
                      );
                    },
                    icon: Icon(
                      Icons.image_search,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon image_search',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 2,
                columnIndex: 2,
                rowSpan: 1,
                columnSpan: 2,
                child: Container(
                  color: Colors.yellow,
                  child: IconButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Jaune()),
                      );
                    },
                    icon: Icon(
                      Icons.ondemand_video,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon ondemand_video',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 3,
                columnIndex: 2,
                rowSpan: 2,
                columnSpan: 1,
                child: Container(
                  color: Colors.deepPurple,
                  child: IconButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Violet()),
                      );
                    },
                    icon: Icon(
                      Icons.space_dashboard,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon space_dashboard',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 3,
                columnIndex: 3,
                rowSpan: 2,
                columnSpan: 1,
                child: Container(
                  color: Colors.amber,
                  child: IconButton(
                    onPressed: () {},
                    icon: Icon(
                      Icons.add_to_drive,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon add_to_drive',
                    ),
                  ),
                ),
              ),

              ExpandedGridContent(
                rowIndex: 4,
                columnIndex: 0,
                rowSpan: 1,
                columnSpan: 2,
                child: Container(
                  color: Colors.teal,
                  child: IconButton(
                    onPressed: () {},
                    icon: Icon(
                      Icons.menu,
                      size: 100,
                      color: Colors.black,
                      semanticLabel: 'icon menu',
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),

      appBar: AppBar(
        title: Text('Expanded Grid'),
        foregroundColor: Colors.white,
        flexibleSpace: ShaderMask(
          shaderCallback:
              (bounds) => LinearGradient(
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
                colors: [
                  Colors.black.withValues(alpha: 0.4),
                  Colors.white.withValues(alpha: 0.4),
                ],
              ).createShader(bounds),
          blendMode: BlendMode.softLight,
          child: Container(color: Colors.deepPurple),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        tooltip: 'Floating Action Button',
        child: Text('press'),
      ),
    );
  }
}
