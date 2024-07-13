#include <opencv2/opencv.hpp>

int main() {
    // Load pre-trained model for object detection
    cv::dnn::Net net = cv::dnn::readNetFromCaffe("deploy.prototxt", "model.caffemodel");

    // Open camera
    cv::VideoCapture cap(0);
    if (!cap.isOpened()) {
        std::cout << "Failed to open camera!" << std::endl;
        return -1;
    }

    // Start capturing and processing frames
    while (true) {
        cv::Mat frame;
        cap.read(frame); // Read frame from camera

        // Perform object detection
        cv::Mat blob = cv::dnn::blobFromImage(frame, 1.0, cv::Size(300, 300), cv::Scalar(104, 177, 123));
        net.setInput(blob);
        cv::Mat detections = net.forward();

        // Process the detections
        for (int i = 0; i < detections.size[2]; i++) {
            float confidence = detections.at<float>(0, 0, i, 2);
            if (confidence > 0.5) {
                int x1 = static_cast<int>(detections.at<float>(0, 0, i, 3) * frame.cols);
                int y1 = static_cast<int>(detections.at<float>(0, 0, i, 4) * frame.rows);
                int x2 = static_cast<int>(detections.at<float>(0, 0, i, 5) * frame.cols);
                int y2 = static_cast<int>(detections.at<float>(0, 0, i, 6) * frame.rows);

                // Draw bounding box
                cv::rectangle(frame, cv::Point(x1, y1), cv::Point(x2, y2), cv::Scalar(0, 255, 0), 2);
            }
        }

        // Display the frame
        cv::imshow("Object Detection", frame);

        // Break loop on 'Esc' key press
        if (cv::waitKey(1) == 27)
            break;
    }

    // Release resources
    cap.release();
    cv::destroyAllWindows();

    return 0;
}

