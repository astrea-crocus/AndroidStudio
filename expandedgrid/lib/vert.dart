import 'package:animator/animator.dart';
import 'package:flutter/material.dart';

import 'main.dart';

class Vert extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Animation Zoom',

      home: Scaffold(
        appBar: AppBar(
          title: Text('Animation Zoom'),
          iconTheme: IconThemeData(color: Colors.white, opacity: 10, size: 100),
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
            child: Container(color: Colors.green),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()),
            );
          },
          backgroundColor: Colors.green,
          foregroundColor: Colors.white,
          child: Icon(Icons.arrow_back),
        ),

        body: Animation()
      ),
    );
  }
}

class Animation extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Animator<double>(
      tween: Tween<double>(begin: 0, end: 1920),
      repeats: 1,
      duration: Duration(seconds: 6),
      builder:
          (context, animatorState, child) => Center(
            child: Container(
              margin: EdgeInsets.symmetric(vertical: 10),
              height: animatorState.value,
              width: animatorState.value,
              child: Card(
                semanticContainer: true,
                clipBehavior: Clip.antiAliasWithSaveLayer,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10.0),
                ),
                elevation: 5,
                margin: EdgeInsets.all(10),
                child: Image.asset(
                  'image/img20250116194405.jpg',
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),
    );
  }
}