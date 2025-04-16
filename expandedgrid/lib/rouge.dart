import 'package:flutter/material.dart';

import 'main.dart';
import 'vertbis.dart';

class Rouge extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'GridView',

      home: Scaffold(
        appBar: AppBar(
          title: Text('GridView'),
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
            child: Container(color: Colors.red),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()),
            );
          },
          backgroundColor: Colors.red,
          foregroundColor: Colors.white,
          child: Icon(Icons.arrow_back),
        ),

        body: Center(
          child: Container(
            margin: EdgeInsets.all(10),
            child: GridView.count(
              scrollDirection: Axis.vertical,
              crossAxisCount: 3,
              children: [
                for (var animal in [
                  {'image': 'image/animals/axolotl.png', 'label': 'axolotl'},
                  {'image': 'image/animals/cerf.png', 'label': 'cerf'},
                  {'image': 'image/animals/chat.png', 'label': 'chat'},
                  {'image': 'image/animals/chien.png', 'label': 'chien'},
                  {'image': 'image/animals/elephant.png', 'label': 'elephant'},
                  {'image': 'image/animals/girafe.png', 'label': 'girafe'},
                  {'image': 'image/animals/hamster.png', 'label': 'hamster'},
                  {'image': 'image/animals/hibou.png', 'label': 'hibou'},
                  {'image': 'image/animals/koala.png', 'label': 'koala'},
                  {'image': 'image/animals/lapin.png', 'label': 'lapin'},
                  {'image': 'image/animals/lion.png', 'label': 'lion'},
                  {'image': 'image/animals/serpent.png', 'label': 'serpent'},
                  {'image': 'image/animals/singe.png', 'label': 'singe'},
                  {'image': 'image/animals/tortue.png', 'label': 'tortue'},
                  {'image': 'image/animals/zebre.png', 'label': 'zèbre'},
                ])
                  Card(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder:
                                (context) =>
                                    VertBis(cheminImage: animal['image']!),
                          ),
                        );
                      },
                      child: ClipRRect(
                        child: Image.asset(
                          animal['image']!,
                          semanticLabel: animal['label'],
                          fit: BoxFit.fill,
                        ),
                      ),
                    ),
                  ),
                // fin boucle FOR
              ],
            ),
          ),
        ),
      ),
    );
  }
}
