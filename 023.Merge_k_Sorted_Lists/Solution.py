import heapq

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        hp = []
        nodes = list(lists)
        for idx in range(len(nodes)):
            node = nodes[idx]
            if node is not None:
                hp.append((node.val, idx))
        heapq.heapify(hp)
        head = None
        prev = None
        while hp:
            val, idx = heapq.heappop(hp)
            node = nodes[idx]
            if head is None:
                head = node
            if prev is not None:
                prev.next = node
            ne = node.next
            if ne is not None:
                heapq.heappush(hp, (ne.val, idx))
                nodes[idx] = ne
            prev = node
        return head