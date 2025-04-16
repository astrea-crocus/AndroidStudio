import 'package:flutter/material.dart';

import 'main.dart';

class Violet extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Image Web',

      home: Scaffold(
        appBar: AppBar(
          title: Text('Image Web'),
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
            child: Container(color: Colors.deepPurple),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()),
            );
          },
          backgroundColor: Colors.deepPurple,
          foregroundColor: Colors.white,
          child: Icon(Icons.arrow_back),
        ),

        body: Center(
          child: SizedBox(
            height: MediaQuery.of(context).size.height * 0.6,
            width: MediaQuery.of(context).size.width * 0.8,
            child: InkWell(
              onTap: () {},
              child: ClipRRect(
                borderRadius: BorderRadius.circular(90.0),
                child: Image.network(
                  'https://i.postimg.cc/MZ0ZxX20/IMG20250116194405.jpg',
                  semanticLabel: 'Macchia',
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
