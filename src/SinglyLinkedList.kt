/**
 * Created by teresaj on 08/01/2019.
 */

fun main(args: Array<String>){
    val list= SinglyLinkedList()
    list.addNode(3)
    list.addNode(4)
    list.addNode(5)
    list.addNode(6)
    list.traverseList()
    println("deleting node 3 ${list.deleteNode(3)}")
    list.traverseList()
    println("deleting node 6 ${list.deleteNode(6)}")
    list.traverseList()
    println("deleting node 6 again ${list.deleteNode(6)}")
    list.traverseList()
    println("find value 4 ${list.findNode(4)}")
    println("find value 6 ${list.findNode(6)}")
    list.traverseReverseOrder()
}

class SinglyLinkedList{
    private var head: Node? = null

    fun addNode(nodeValue: Int){
        if(head==null){
            head= Node(nodeValue, null)
        }else{
            val previousHead= head
            head= Node(nodeValue, head)
        }
    }

    fun traverseList(){
        var currentNode= head
        while(currentNode !=null){
            print(", ${currentNode.value}")
            currentNode= currentNode.next
        }
        println()
    }

    fun deleteNode(value: Int): Boolean{
        var currentNode= head
        var previousNode: Node? = null
        while(currentNode !=null){
            if(currentNode.value== value){
                if(previousNode!=null){
                    previousNode.next= currentNode.next
                    return true
                }
                else{
                    head= currentNode.next
                    return true
                }
            }
            previousNode= currentNode
            currentNode= currentNode.next
        }
        return false
    }

    fun findNode(value: Int): Boolean{
        var currentNode= head
        while(currentNode!=null){
            if(currentNode.value== value){
                return true
            }
            currentNode= currentNode.next
        }
        return false
    }

    fun traverseReverseOrder(){
        var lastNode= head
        while(lastNode!=null){
            lastNode= lastNode.next
        }
        print(", ${lastNode?.value}")
        var currentNode= head

        if(currentNode!=null){
            while(lastNode!= head) {
                while (currentNode!=null && currentNode.next != lastNode) {
                    currentNode= currentNode.next
                }
                lastNode= currentNode
                currentNode?.let {
                    print(", ${it.value}")
                }
            }
        }
    }
}

class Node(val value: Int, var next: Node?)