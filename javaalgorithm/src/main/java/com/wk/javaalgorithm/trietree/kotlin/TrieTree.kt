package com.wk.javaalgorithm.trietree.kotlin

class TrieNode {
    val children = HashMap<Char, TrieNode?>()
    var word: String? = null


    companion object {
        fun createTrie(words: Array<String>): TrieNode {
            val root = TrieNode()
            words.forEach { word ->
                var node = root
                node = insertTrie(word, node)
                node.word = word
            }
            return root
        }

        fun insertTrie(word: String, node: TrieNode): TrieNode {
            var tempNode = node
            word.forEach { char ->
                tempNode = tempNode.children.getOrDefault(char, null) ?: run {
                    val newNode = TrieNode()
                    tempNode.children[char] = newNode
                    newNode
                }
            }
            return tempNode
        }

        fun searchTrie(word: String?, node: TrieNode): Boolean {
            var tempNode = node
            if (word.isNullOrEmpty()) return false
            word.forEach { letter ->
                tempNode = tempNode.children.getOrDefault(letter, null) ?: return false
            }
            return tempNode.word != null
        }

        fun startWith(word: String?, node: TrieNode): Boolean {
            var tempNode = node
            if (word.isNullOrEmpty()) return false
            word.forEach { letter ->
                tempNode = tempNode.children.getOrDefault(letter, null) ?: return false
            }
            return true
        }
    }

    val list = arrayListOf<String>()
    lateinit var array: Array<CharArray>

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val node = createTrie(words)
        this.array = board
        board.forEachIndexed { row, chars ->
            chars.forEachIndexed { col, c ->
                if (node.children.containsKey(c)) {
                    backtracking(row, col, node)
                }
            }
        }
        return list
    }

    private fun backtracking(row: Int, col: Int, parent: TrieNode?) {
        val letter = array[row][col]
        val currentNode = parent?.children?.get(letter)
        if (currentNode?.word != null) {
            this.list.add(currentNode.word!!)
            currentNode.word = null
        }

        this.array[row][col] = '&'

        val rowOffset = intArrayOf(-1, 0, 1, 0)
        val colOffset = intArrayOf(0, 1, 0, -1)

        for (i in 0..3) {
            val newRow = row + rowOffset[i]
            val newCol = col + colOffset[i]
            if (newCol < 0 || newCol >= array[0].size || newRow < 0 || newRow >= array.size) {
                continue
            }
            if (currentNode?.children?.containsKey(array[newRow][newCol]) == true) {
                backtracking(newRow, newCol, currentNode)
            }
        }

        this.array[row][col] = letter

        if (currentNode?.children.isNullOrEmpty()) {
            parent?.children?.remove(letter)
        }
    }
}



