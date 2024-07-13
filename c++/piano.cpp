#include <iostream>
#include <cmath>
#include <portaudio.h>
#include <RtMidi.h>

// Constants for audio settings
const int SAMPLE_RATE = 44100;
const int FRAMES_PER_BUFFER = 64;
const double BASE_FREQUENCY = 440.0;

// Global variables for audio and MIDI
PaStream* audioStream;
RtMidiIn* midiIn;

// Callback function for audio stream
int audioCallback(const void* inputBuffer, void* outputBuffer,
                  unsigned long framesPerBuffer,
                  const PaStreamCallbackTimeInfo* timeInfo,
                  PaStreamCallbackFlags statusFlags,
                  void* userData)
{
    float* out = (float*)outputBuffer;
    unsigned int i;
    (void)inputBuffer; // Prevent unused variable warning

    for (i = 0; i < framesPerBuffer; i++)
    {
        // Generate sine wave for each note
        double frequency = BASE_FREQUENCY * pow(2.0, (i % 12) / 12.0);
        *out++ = 0.2f * sin(2.0 * M_PI * frequency * i / SAMPLE_RATE);
    }

    return paContinue;
}

// Callback function for MIDI input
void midiCallback(double deltaTime, std::vector<unsigned char>* message, void* userData)
{
    // Handle MIDI events here
    // You can use the 'message' vector to access MIDI data
}

int main()
{
    // Initialize PortAudio
    Pa_Initialize();

    // Open the audio stream
    Pa_OpenDefaultStream(&audioStream, 0, 1, paFloat32,
                         SAMPLE_RATE, FRAMES_PER_BUFFER, audioCallback, NULL);

    // Start the audio stream
    Pa_StartStream(audioStream);

    // Initialize RtMidi
    midiIn = new RtMidiIn();

    // Set the MIDI input callback function
    midiIn->setCallback(&midiCallback);

    // Open the first available MIDI input port
    midiIn->openPort(0);

    // Enable MIDI input
    midiIn->ignoreTypes(false, false, false);

    std::cout << "Digital piano started. Press Enter to quit." << std::endl;
    std::cin.ignore(); // Wait for user input

    // Stop and close the audio stream
    Pa_StopStream(audioStream);
    Pa_CloseStream(audioStream);

    // Clean up PortAudio
    Pa_Terminate();

    // Clean up RtMidi
    delete midiIn;

    return 0;
}

