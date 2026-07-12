package com.evacuationsimulator.algorithms;

import com.evacuationsimulator.model.RescueRequest;

import java.util.PriorityQueue;

public class PriorityQueueManager {

    private PriorityQueue<RescueRequest> rescueQueue;

    public PriorityQueueManager() {

        rescueQueue = new PriorityQueue<>();

    }

    public void addRequest(RescueRequest request) {

        rescueQueue.offer(request);

    }

    public RescueRequest processNextRequest() {

        return rescueQueue.poll();

    }

    public int getPendingRequestCount() {

        return rescueQueue.size();

    }

    public String getQueueAsString() {

        if (rescueQueue.isEmpty()) {

            return """
====================================
EMERGENCY RESCUE QUEUE
====================================

No Pending Rescue Requests.
""";

        }

        StringBuilder output = new StringBuilder();

        output.append("""
====================================
EMERGENCY RESCUE QUEUE
====================================

""");

        int count = 1;

        for (RescueRequest request : rescueQueue) {

            output.append(count++)
                    .append(". ")
                    .append(request)
                    .append("\n------------------------------------\n");

        }

        output.append("\nTotal Requests : ")
                .append(rescueQueue.size());

        return output.toString();

    }

}