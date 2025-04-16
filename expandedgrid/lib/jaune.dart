import 'package:chewie/chewie.dart';
import 'package:flutter/material.dart';
import 'package:video_player/video_player.dart';

import 'main.dart';

class Jaune extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',

      home: Scaffold(
        appBar: AppBar(
          title: Text('Video Player'),
          iconTheme: IconThemeData(color: Colors.white, opacity: 10, size: 100),
          foregroundColor: Colors.black,

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
            child: Container(color: Colors.yellow),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()),
            );
          },
          backgroundColor: Colors.yellow,
          foregroundColor: Colors.black,
          child: Icon(Icons.arrow_back),
        ),

        body: MyVideo(),
      ),
    );
  }
}

final videoPlayerController = VideoPlayerController.networkUrl(
  Uri.parse(
    'http://parc.imperial.free.fr/TDvideo/big_buck_bunny_720p_20mb.mp4',
  ),
);

final chewieController = ChewieController(
  videoPlayerController: videoPlayerController,
  aspectRatio: 16 / 9,
  autoInitialize: true,
);

class MyVideo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: SizedBox(
          height: MediaQuery.of(context).size.height * 0.8,
          width: MediaQuery.of(context).size.width * 0.8,
          child: Chewie(controller: chewieController),
        ),
      ),
    );
  }
}
