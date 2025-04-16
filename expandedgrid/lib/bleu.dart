import 'package:animate_do/animate_do.dart';
import 'package:flutter/material.dart';

import 'main.dart';

class Bleu extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',

      home: Scaffold(
        appBar: AppBar(
          title: Text('Spin Animation'),
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
            child: Container(color: Colors.blue),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()),
            );
          },
          backgroundColor: Colors.blue,
          foregroundColor: Colors.white,
          child: Icon(Icons.arrow_back),
        ),

        body: Center(
          child: Spin(
            infinite: true,
            delay: Duration(seconds: 1),
            duration: Duration(seconds: 3),
            child: Icon(
              Icons.adb,
              size: 300,
              color: Colors.blue,
              semanticLabel: 'Robot',
            ),
          ),
        ),
      ),
    );
  }
}
